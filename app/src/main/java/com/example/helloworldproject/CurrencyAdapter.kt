package com.example.helloworldproject

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class CurrencyAdapter(private val context: Context, private val values: Array<String>): BaseAdapter() {
    fun getPosition(item: String): Int {
        return values.indexOf(item)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {

        return createDropdownViewFromResource(position, convertView, parent)
    }
    override fun getCount(): Int {
        return values.count()
    }

    override fun getItem(position: Int): String {
        return values[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View{
        val layout: ConstraintLayout = convertView as ConstraintLayout? ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false) as ConstraintLayout
        val image: ImageView = layout.findViewById(R.id.currencyImage)
        image.setImageResource(drawables[position])

        val text: TextView = layout.findViewById(R.id.currencyName)
        text.text = values[position]
        return layout
    }
    private fun createDropdownViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View{
        val layout: ConstraintLayout = convertView as ConstraintLayout? ?: LayoutInflater.from(context).inflate(R.layout.dropdown_item, parent, false) as ConstraintLayout
        val image: ImageView = layout.findViewById(R.id.currencyImage)
        image.setImageResource(drawables[position])

        val text: TextView = layout.findViewById(R.id.currencyName)
        text.text = values[position]
        return layout
    }
    private val drawables: Array<Int> = arrayOf(
        R.drawable.aed, R.drawable.afn, R.drawable.all, R.drawable.amd,
        R.drawable.ang, R.drawable.aoa, R.drawable.ars, R.drawable.aud,
        R.drawable.awg, R.drawable.azn, R.drawable.bam, R.drawable.bbd,
        R.drawable.bdt, R.drawable.bgn, R.drawable.bhd, R.drawable.bif,
        R.drawable.bmd, R.drawable.bnd, R.drawable.bob, R.drawable.brl,
        R.drawable.bsd, R.drawable.btc, R.drawable.btn, R.drawable.bwp,
        R.drawable.byn, R.drawable.byr, R.drawable.bzd, R.drawable.cad,
        R.drawable.cdf, R.drawable.chf, R.drawable.clf, R.drawable.clp,
        R.drawable.cny, R.drawable.cop, R.drawable.crc, R.drawable.cuc,
        R.drawable.cup, R.drawable.cve, R.drawable.czk, R.drawable.djf,
        R.drawable.dkk, R.drawable.dop, R.drawable.dzd, R.drawable.egp,
        R.drawable.ern, R.drawable.etb, R.drawable.eur, R.drawable.fjd,
        R.drawable.fkp, R.drawable.gbp, R.drawable.gel, R.drawable.ggp,
        R.drawable.ghs, R.drawable.gip, R.drawable.gmd, R.drawable.gnf,
        R.drawable.gtq, R.drawable.gyd, R.drawable.hkd, R.drawable.hnl,
        R.drawable.hrk, R.drawable.htg, R.drawable.huf, R.drawable.idr,
        R.drawable.ils, R.drawable.imp, R.drawable.inr, R.drawable.iqd,
        R.drawable.irr, R.drawable.isk, R.drawable.jep, R.drawable.jmd,
        R.drawable.jod, R.drawable.jpy, R.drawable.kes, R.drawable.kgs,
        R.drawable.khr, R.drawable.kmf, R.drawable.kpw, R.drawable.krw,
        R.drawable.kwd, R.drawable.kyd, R.drawable.kzt, R.drawable.lak,
        R.drawable.lbp, R.drawable.lkr, R.drawable.lrd, R.drawable.lsl,
        R.drawable.ltl, R.drawable.lvl, R.drawable.lyd, R.drawable.mad,
        R.drawable.mdl, R.drawable.mga, R.drawable.mkd, R.drawable.mmk,
        R.drawable.mnt, R.drawable.mop, R.drawable.mro, R.drawable.mur,
        R.drawable.mvr, R.drawable.mwk, R.drawable.mxn, R.drawable.myr,
        R.drawable.mzn, R.drawable.nad, R.drawable.ngn, R.drawable.nio,
        R.drawable.nok, R.drawable.npr, R.drawable.nzd, R.drawable.omr,
        R.drawable.pab, R.drawable.pen, R.drawable.pgk, R.drawable.php,
        R.drawable.pkr, R.drawable.pln, R.drawable.pyg, R.drawable.qar,
        R.drawable.ron, R.drawable.rsd, R.drawable.rub, R.drawable.rwf,
        R.drawable.sar, R.drawable.sbd, R.drawable.scr, R.drawable.sdg,
        R.drawable.sek, R.drawable.sgd, R.drawable.shp, R.drawable.sle,
        R.drawable.sll, R.drawable.sos, R.drawable.srd, R.drawable.ssp,
        R.drawable.std, R.drawable.svc, R.drawable.syp, R.drawable.szl,
        R.drawable.thb, R.drawable.tjs, R.drawable.tmt, R.drawable.tnd,
        R.drawable.top, R.drawable.try_, R.drawable.ttd, R.drawable.twd,
        R.drawable.tzs, R.drawable.uah, R.drawable.ugx, R.drawable.usd,
        R.drawable.uyu, R.drawable.uzs, R.drawable.vef, R.drawable.ves,
        R.drawable.vnd, R.drawable.vuv, R.drawable.wst, R.drawable.xaf,
        R.drawable.xcd, R.drawable.xpf, R.drawable.yer, R.drawable.zar,
        R.drawable.zmk, R.drawable.zmw, R.drawable.zwl,
    )
}