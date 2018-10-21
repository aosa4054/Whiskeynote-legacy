package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context.WINDOW_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Point
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.scale
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputLayout
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.data.entity.Whiskey
import kotlinx.android.synthetic.main.fragment_add_edit_whiskey.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions
import java.io.IOException
import java.util.*

@RuntimePermissions
class AddEditWhiskeyFragment(): androidx.fragment.app.Fragment(), AddEditWhiskeyNavigator{

    private var typeFlag = 0
    private lateinit var mView: View
    private var mViewModel: AddEditWhiskeyViewModel? = null

    lateinit var uri: Uri
    private val REQUEST_CHOOSER = 1000


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_add_edit_whiskey, container, false)
        typeFlag = activity!!.intent.getIntExtra("Type Flag", 0)
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModel()
        aew_image_button.setOnClickListener { v -> setgetImage() }
        setupSaveButton()
        setupCancelButton()
    }

    private fun setupSaveButton(){
        activity?.findViewById<AppCompatButton>(R.id.btn_save)?.setOnClickListener{mViewModel!!.saveWhiskey()}
    }
    private fun setupCancelButton(){
        activity?.findViewById<AppCompatButton>(R.id.btn_cancel)?.setOnClickListener { backToList() }
    }

    private fun setupViewModel(){
        mViewModel = ViewModelProviders.of(this).get(AddEditWhiskeyViewModel::class.java)
        mViewModel!!.setTypeFlag(typeFlag)
        val act = AddEditWhiskeyActivity()
        mViewModel!!.setupNavigator(this)
    }

    //こっからためし
    override fun getViewData(): Whiskey {
        val r = Random()
        val id = r.nextInt()
        val name = mView.findViewById<TextInputLayout>(R.id.text_input_name).editText!!.text.toString()
        val type = mView.findViewById<TextInputLayout>(R.id.text_input_kind).editText!!.text.toString()
        val price = mView.findViewById<TextInputLayout>(R.id.text_input_price).editText!!.text.toString()
        val ml = mView.findViewById<TextInputLayout>(R.id.text_input_ml).editText!!.text.toString()
        val fragrance = mView.findViewById<TextInputLayout>(R.id.text_input_fragrance).editText!!.text.toString()
        val taste = mView.findViewById<TextInputLayout>(R.id.text_input_taste).editText!!.text.toString()
        val aftertaste = mView.findViewById<TextInputLayout>(R.id.text_input_aftertaste).editText!!.text.toString()
        val memo = mView.findViewById<TextInputLayout>(R.id.text_input_memo).editText!!.text.toString()

        Log.d("Result", "$name, $type, $fragrance, $taste, $aftertaste, $memo")
        val whiskey = Whiskey(id, "Others", name, type, price, ml, fragrance, taste, aftertaste, memo)

        //TODO whenでflagに応じてkindを設定

        return whiskey
    }

    //Navigatorからウイスキーのflagを入力してもらうダイアログを生成、ViewModelに渡して保存してもらう
    override fun chooseWhiskeyType(){
        var selected: Int = 0
        val items = arrayOf("Scotch", "American", "Japanese", "Others")
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)

        builder.setMessage("ウィスキーの種類を選択してください")
                .setSingleChoiceItems(items, selected, DialogInterface.OnClickListener(fun (dialog: DialogInterface, which: Int){selected = which}))
                .setPositiveButton("OK", DialogInterface.OnClickListener(fun (dialog: DialogInterface, which: Int){mViewModel!!.saveWhiskeyViaDialog(selected + 1)}))
                .show()
    }

    override fun backToList() { activity!!.finish() }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    fun setgetImage(){
        val photoName = System.currentTimeMillis().toString() + ".jpg"
        val contentValues = ContentValues()
        contentValues.put(MediaStore.Images.Media.TITLE, photoName)
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        uri = activity!!.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) ?: return
        val camIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        camIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

        val gallIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        gallIntent.addCategory(Intent.CATEGORY_OPENABLE)
        gallIntent.type = "image/jpeg"
        val intent = Intent.createChooser(camIntent, "ギャラリーから選択")
        intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(gallIntent))
        startActivityForResult(intent, REQUEST_CHOOSER);
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CHOOSER) {
            if (resultCode != Activity.RESULT_OK) {
                return
            }
            val resultUri = (if (data != null) data.data else uri) ?: return
            MediaScannerConnection.scanFile(activity,
                    arrayOf(resultUri.path),
                    arrayOf("image/jpeg"),
                    null)

            //
            val wm: WindowManager = activity!!.getSystemService(WINDOW_SERVICE) as WindowManager
            val disp = wm.getDefaultDisplay()
            val realSize = Point()
            disp.getRealSize(realSize)
            val x = realSize.x

            lateinit var bitmap: Bitmap
            try {
                val sourceBitmap = MediaStore.Images.Media.getBitmap(activity!!.contentResolver, resultUri)
                bitmap = Bitmap.createBitmap(sourceBitmap, 0, 0, sourceBitmap.width, aew_image.height, null, true)
            }catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(activity, "画像の変換でエラーが発生しました", Toast.LENGTH_SHORT).show()
            }

            aew_image.setImageBitmap(bitmap)
            aew_image_button.setBackgroundColor(Color.parseColor("#88999999"))

        }
    }
}