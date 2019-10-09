package tj.belajar.asu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_list_item.view.*

@Suppress("UNREACHABLE_CODE")
class ContactAdapter(val phoneItemList: List<PhoneData>, val clickListener: (PhoneData) -> Unit):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_list_item, parent, false)
        return PartViewHolder(view)

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        (holder as  PartViewHolder).bind(phoneItemList[position],clickListener)
    }

    override fun getItemCount()=phoneItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(phone: PhoneData, clickListener: (PhoneData) -> Unit){
            itemView.tv_part_item_name.text= phone.contactName
            itemView.tv_part_item_id.text=phone.phone.toString()
            itemView.setOnClickListener{clickListener(phone)}
        }
    }
}