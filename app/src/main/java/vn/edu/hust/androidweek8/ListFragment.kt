package vn.edu.hust.androidweek8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val list = view.findViewById<RecyclerView>(R.id.listView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Prepare arrays of data with random names and phone numbers
        val itemList = arrayListOf<ItemModel>()
        val random = Random()

        for (i in 1..24) {
            val randomName = generateRandomName()
            val randomNumber = generateRandomPhoneNumber()

            itemList.add(
                ItemModel(
                    i,
                    randomName,
                    randomNumber,
                    "$randomName@gmail.com"
                )
            )
        }

        val adapter = MyCustomAdapter(itemList, requireContext())
        val list: RecyclerView = view.findViewById(R.id.listView)
        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = adapter
    }

    private fun generateRandomName(): String {
        val names = arrayOf("John", "Jane", "Michael", "Emily", "David", "Olivia", "Daniel", "Sophia", "Christopher", "Emma")
        return names[Random().nextInt(names.size)]
    }

    private fun generateRandomPhoneNumber(): String {
        val randomNumber = Random().nextInt(900000000) + 100000000
        return "0$randomNumber"
    }

    companion object {
        @JvmStatic fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}