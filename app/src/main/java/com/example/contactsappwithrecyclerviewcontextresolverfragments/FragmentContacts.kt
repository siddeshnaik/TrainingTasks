package com.example.contactsappwithrecyclerviewcontextresolverfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Contacts.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentContacts : Fragment(), CoroutineScope {

//    val contactInfo: ArrayList<PhoneContactData> = ArrayList()

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    lateinit var recycler_view: RecyclerView
    lateinit var layoutInflated: View

    val contactHelper by lazy { ContactHelper() }
//    val phoneContactsData by lazy {
//        contactHelper.getContactList(requireContext())
//    }

    var phoneData = ArrayList<PhoneContactData>()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutInflated = inflater.inflate(R.layout.fragment__contacts, container, false)
        return layoutInflated
    }

    private suspend fun contactHelperGetData() :ArrayList<PhoneContactData> {
        return withContext(Dispatchers.IO){contactHelper.getContactList(requireContext())}

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launch {
            phoneData = contactHelperGetData()
            recycler_view = layoutInflated.findViewById(R.id.recyclerViewContacts)
            recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)

                adapter = RecyclerAdapter().apply {
                    setContactInfo(phoneData)

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
         * @return A new instance of fragment Fragment_Contacts.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentContacts().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}