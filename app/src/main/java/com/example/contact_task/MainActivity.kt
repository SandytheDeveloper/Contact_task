package com.example.contact_task

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var conlist= arrayOf("Rahul","Sangam","Sonal","Bhargav","Manan","Sagar","Bhavin","Bhavika","Yana")
    var phone = arrayOf(12346,456456,456456,123456,789456131,456123,485962,478596,456123)
    lateinit var lv : ListView
    lateinit var bt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv=findViewById(R.id.lvitem)
        bt=findViewById(R.id.btn)

        var ad=ArrayAdapter(this,android.R.layout.simple_list_item_1,conlist)

        lv.adapter=ad

        registerForContextMenu(lv)

        bt.setOnClickListener {
//            val mUri: Uri = Uri.parse("market://details?id=com.example.mail_demo")
//            val mIntent = Intent(Intent.ACTION_VIEW, mUri)
//            startActivity(mIntent)

            val callIntent: Intent = Uri.parse("tel:5551234").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }

        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.popmenu,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var list =item.menuInfo as AdapterView.AdapterContextMenuInfo

        when(item.itemId)
        {
            R.id.call->Toast.makeText(applicationContext,"Calling",Toast.LENGTH_SHORT).show()
            R.id.mail->Toast.makeText(applicationContext,"Mailing",Toast.LENGTH_SHORT).show()
        }


        return super.onContextItemSelected(item)
    }

}

