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
        rv_part.adapter = ContactAdapter(testData, {PhoneItem : PhoneData->phoneItemClicked(PhoneItem)})
    }



    private fun phoneItemClicked (PhoneItem : PhoneData){
        val  showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, PhoneItem.phone.toString())
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneDate() : List<PhoneData>{
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(3043789,"alpa"))
        partList.add(PhoneData(3563587,"paihi"))
        partList.add(PhoneData(3343254,"asu6i"))
        return partList
    }
}
