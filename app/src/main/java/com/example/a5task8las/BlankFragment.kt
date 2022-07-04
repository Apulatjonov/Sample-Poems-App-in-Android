package com.example.a5task8las

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*
import kotlinx.android.synthetic.main.itemsher.*
import kotlinx.android.synthetic.main.itemsher.view.*

private const val ARG_PARAM1 = "param1"
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    lateinit var root:View
    lateinit var resp:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_blank, container, false)
        var list= mutableListOf<Sher>()
        resp = ""
        resp = arguments?.getString("resp")!!
        list = arguments?.getParcelableArrayList("1")!!
        when(resp){
            "1" -> {
                root.stxt.setText("SEVGI\nNSHE'RLARI")
            }
            "2" -> {
                root.stxt.setText("SOG'INCH\nARMON")
            }
            "3" -> {
                root.stxt.setText("TABRIK\nSHE'RLARI")
            }
            "4" -> {
                root.stxt.setText("OTA-ONA\nHAQIDA")
            }
            "5" -> {
                root.stxt.setText("DO'STLIK\nSHE'RLARI")
            }
            "6" -> {
                root.stxt.setText("HAZIL\nSHE'RLAR")
            }
            "7" -> {
                root.stxt.setText("SAQLANGAN\nSHE'RLAR")
            }
            "8" -> {
                root.stxt.setText("YANGI\nSHE'RLAR")
            }
        }
        println(list.size)
        root.rcv.adapter = MyAdapter(list, root.context, object : myInter {
            override fun onMyItemClick(position: Int) {
                val dialog = BottomSheetDialog(root.context, R.style.SheetDialog)
                val view = LayoutInflater.from(root.context).inflate(R.layout.itemsher, null, false)
                var txt = ""
                var theLast = 0
                var num = -1
                for (i in list[position].name.toString()) {
                    txt += i.toString()
                    num ++
                    if (i.toString() == " " && num < 27) {
                        theLast = num
                    }
                }
                var txt2 = ""
                if (txt.contains("\n")) {
                    for (i in 0 until theLast) {
                        txt2 += txt[i]
                    }
                    txt2 += "\n"
                    for (i in theLast + 1 until txt.length) {
                        txt2 += txt[i]
                    }
                }else{
                    txt2 = txt
                }
                view.poemtitle.text = txt2
                var txt3 = ""

                var num1 = -1
                for (i in list[position].txt.toString()) {
                    txt3 += i.toString()
                    num1 ++
                    if (i.toString() == "\n"){
                        num1 = 0
                    }
                    if (i.toString() == " " && num1 > 30) {
                        txt3 += "\n"
                    }
                }
                view.poemtxt.text = txt3
                if(list[position].liked == true){
                    view.likeBtn.setImageResource(R.drawable.liked)
                }else{
                    view.likeBtn.setImageResource(R.drawable.likelogo)
                }
                dialog.setContentView(view)
                dialog.show()
                view.likeLogo.setOnClickListener {
                    if(list[position].liked == true){
                        list[position].liked = false
                        view.likeBtn.setImageResource(R.drawable.likelogo)
                        rcv.adapter?.notifyItemChanged(position)
                    }else{
                        list[position].liked = true
                        view.likeBtn.setImageResource(R.drawable.liked)
                        rcv.adapter?.notifyItemChanged(position)
                    }
                }
            }

        })
        root.backk.setOnClickListener {
            findNavController().popBackStack()
        }
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BlankFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                    }
                }
    }

}