package com.example.contactsappwithrecyclerviewcontextresolverfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Fav_Contact.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFavContact : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<FavRecyclerAdapter.ViewHolder>? = null

    lateinit var recycler_view2: RecyclerView
    lateinit var layoutInflated2: View

    val contactHelper by lazy { ContactHelper() }
    val phoneContactsDataFav by lazy { contactHelper.getFavContactList(requireContext()) }

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
        layoutInflated2 = inflater.inflate(R.layout.fragment__fav__contact, container, false)
        return layoutInflated2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val textView_Fav:TextView = layoutInflated2.findViewById(R.id.textView_Fav)
        Log.i("Siddesh Test", phoneContactsDataFav.size.toString())
        if(phoneContactsDataFav.size == 0){
            textView_Fav.visibility = android.view.View.VISIBLE
            textView_Fav.setText("No favourite Contact Available")

        }else{
            recycler_view2 = layoutInflated2.findViewById(R.id.recyclerViewFavContacts)
            recycler_view2.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView
                adapter = FavRecyclerAdapter().apply {
                    setContactInfo(phoneContactsDataFav)

                }
            }
        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_Fav_Contact.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentFavContact().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}