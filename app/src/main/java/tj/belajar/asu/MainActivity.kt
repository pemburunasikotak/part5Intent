package tj.belajar.asu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneDate()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ContactAdapter(testData, {phoneItem : PhoneData->phoneItemClicked(phoneItem)})
    }



    private fun phoneItemClicked (phoneItem : PhoneData){
        val  showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneDate() : List<PhoneData>{
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(85786534862,"Tj"))
        partList.add(PhoneData(85786534861,"JK"))
        partList.add(PhoneData(85786534863,"TK"))
        return partList
    }
}
