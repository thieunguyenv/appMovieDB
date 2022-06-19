package com.nvt.moviedbapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nvt.moviedbapp.databinding.ItemViewPagerTrendingBinding
import com.nvt.moviedbapp.ui.model.TravelLocation
import com.squareup.picasso.Picasso


class TravelLocationAdapter : RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder> {

    private lateinit var travellocation: List<TravelLocation>
    private lateinit var context: Context

    constructor(context: Context, travelLocation: List<TravelLocation>) {
        this.context = context
        this.travellocation = travelLocation
    }

    inner class TravelLocationViewHolder(private val itemBinding:ItemViewPagerTrendingBinding) : RecyclerView.ViewHolder(itemBinding.root) {

//        internal var kbvLocation: KenBurnsView
//        internal var textTitle: TextView
//        internal var textLocation: TextView
//        internal var textStartRating: TextView

//        init {
//            kbvLocation = itemView.findViewById(R.id.kbvLocation)
//            textTitle = itemView.findViewById(R.id.textTitle)
//            textStartRating = itemView.findViewById(R.id.textStartRating)
//            textLocation = itemView.findViewById(R.id.textLocation)
//        }

        fun setLocationData(travelLocation: TravelLocation) {
            Picasso.with(itemView.context).load(travelLocation.imageUrl).into(itemBinding.kbvLocation)
//            textTitle!!.text = travelLocation.title
//            textLocation.setText(travelLocation.location)
//            textStartRating.setText(travelLocation.startRating.toString())
            itemBinding.textTitle.text = travelLocation.title
            itemBinding.textLocation.setText(travelLocation.location)
            itemBinding.textStartRating.setText(travelLocation.startRating.toString())
        }
//        class PaymentHolder() :
//            RecyclerView.ViewHolder() {
//            fun bind(paymentBean: PaymentBean) {
//                itemBinding.tvPaymentInvoiceNumber.text = paymentBean.invoiceNumber
//                itemBinding.tvPaymentAmount.text = paymentBean.totalAmount
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelLocationViewHolder {
//        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_pager, parent, false)
//        return TravelLocationViewHolder(itemView)
        val itemView =
           ItemViewPagerTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TravelLocationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TravelLocationViewHolder, position: Int) {
        holder.setLocationData(travellocation.get(position))
    }

    override fun getItemCount(): Int {
        return travellocation.size
    }
}