package com.rezoo.myapp54mvc.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rezoo.myapp54mvc.ItemVieModel
import com.rezoo.myapp54mvc.MainActivity2
import com.rezoo.myapp54mvc.R

class CustomAdapter(private val mlist:List<ItemVieModel>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel=mlist[position]
        holder.imageview.setImageBitmap(itemViewModel.Image)
        holder.textViewName.text=itemViewModel.name
        holder.textViewFamily.text=itemViewModel.family
        holder.textViewAddress.text=itemViewModel.address
        holder.textviewEmail.text=itemViewModel.email
        holder.cardview.setOnClickListener(View.OnClickListener {
            val context=holder.cardview.context
            val intent:Intent= Intent(context,MainActivity2::class.java)
            intent.putExtra("p",itemViewModel.email)
            context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val cardview=itemView.findViewById<CardView>(R.id.cardview)
        val imageview: ImageView =itemView.findViewById(R.id.imgview)
        val textViewName: TextView =itemView.findViewById(R.id.txtviewname )
        val textViewFamily: TextView =itemView.findViewById(R.id.txtviewfamily )
        val textViewAddress: TextView =itemView.findViewById(R.id.txtviewAddress )
        val textviewEmail:TextView=itemView.findViewById(R.id.txtviewemail)
    }

}