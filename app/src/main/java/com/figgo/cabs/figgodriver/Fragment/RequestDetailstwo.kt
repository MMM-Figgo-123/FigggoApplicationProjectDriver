package com.figgo.cabs.figgodriver.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.figgo.cabs.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RequestDetailstwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class RequestDetailstwo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_request_detailstwo, container, false)

        var request = view.findViewById<Button>(R.id.details_button)
        var allRide = view.findViewById<Button>(R.id.allride_button)
        var f1 = Details()
        var f2 = AllRideLast()


        parentFragmentManager.beginTransaction().apply {
            replace(R.id.reqeustdetails_framelayout, f1)
        }
        request.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.reqeustdetails_framelayout,f1)
            }
        }
        allRide.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.reqeustdetails_framelayout,f2)
            }

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RequestDetailstwo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RequestDetailstwo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}