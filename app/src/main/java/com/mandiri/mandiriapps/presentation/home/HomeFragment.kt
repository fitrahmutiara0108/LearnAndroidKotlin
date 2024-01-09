package com.mandiri.mandiriapps.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.MenuHomeAdapter
import com.mandiri.mandiriapps.adapter.SavingAdapter
import com.mandiri.mandiriapps.adapter.ServiceMenuAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentHomeBinding
import com.mandiri.mandiriapps.helper.SharedPref
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.SavingModel
import com.mandiri.mandiriapps.model.ServiceModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        sharedPref = SharedPref(requireContext())
        binding.vComponentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(createDummyEwalletList())

        listSaving=populateSavingData()
        savingAdapter= SavingAdapter(listSaving)
        binding.vComponentHomeSaving.rvSaving.adapter = savingAdapter

        setUpViewService()
        setUpViewEwallet()
        updateSaving()
    }
//    simbol ! untuk menandakan tidak null

    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null

    private lateinit var savingAdapter: SavingAdapter
    private lateinit var menuAdapter: MenuHomeAdapter
    private lateinit var listSaving: MutableList<SavingModel>
    private lateinit var serviceMenuAdapter: ServiceMenuAdapter
    private lateinit var  listServiceMenu:MutableList<ServiceModel>
    private lateinit var sharedPref: SharedPref

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return FragmentHomeBinding.inflate(inflater, container, false).root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setupLogOut(){

    }

    private fun setUpViewEwallet(){
        dummyEwalletList = createDummyEwalletList()

        binding.vComponentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet { Ewallet ->
            Toast.makeText(context, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()

            dummyEwalletList?.forEach{
                if(it.name == Ewallet.name) it.isConnected = true
            }

            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }

    private fun createDummyEwalletList(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gojek", image = R.drawable.ic_shopee, balance = 400000.00, isConnected = false),
            EwalletModel(name = "Shopee", image = R.drawable.ic_shopee, balance = 100000.00, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_shopee, balance = 200000.00, isConnected = false),
            EwalletModel(name = "LinkAja", image = R.drawable.ic_shopee, balance = 300000.00, isConnected = false)
        )
    }

    private fun setUpViewSaving(){
//        dummySavingList = populateSavingData()
        binding.vComponentHomeSaving.rvSaving.adapter = SavingAdapter(populateSavingData())
    }
    private fun populateSavingData() : MutableList<SavingModel> {
        return mutableListOf(
            SavingModel(
                savingName = "Tabungan NOW IDR",
                accountNumber = "1234567899876543",
                imageCard = R.drawable.ic_cropped_card
            ),
            SavingModel(
                savingName = "Mandiri Tabungan Rencana",
                accountNumber = "1234567899876543",
                imageCard = R.drawable.ic_cropped_card
            ),
            SavingModel(
                savingName = "Tabungan Reguler",
                accountNumber = "1234567899876543",
                imageCard = R.drawable.ic_cropped_card
            )
        )
    }

    private fun createDummyServiceList():MutableList<ServiceModel>{
        return mutableListOf(
            ServiceModel(R.drawable.ic_livinmandiri,"Transfer\nRupiah"),
            ServiceModel(R.drawable.ic_livinmandiri,"Bayar"),
            ServiceModel(R.drawable.ic_livinmandiri,"Top-up"),
            ServiceModel(R.drawable.ic_livinmandiri,"e-money"),
            ServiceModel(R.drawable.ic_livinmandiri,"Sukha"),
            ServiceModel(R.drawable.ic_livinmandiri,"Transfer\nValas"),
            ServiceModel(R.drawable.ic_livinmandiri,"QR Terima\nTransfer"),
            ServiceModel(R.drawable.ic_livinmandiri,"QR Bayar"),
            ServiceModel(R.drawable.ic_livinmandiri,"Tap to Pay"),
            ServiceModel(R.drawable.ic_livinmandiri,"Investasi"),
            ServiceModel(R.drawable.ic_livinmandiri,"Layanan Cabang"),
            ServiceModel(R.drawable.ic_livinmandiri,"Setor Tarik"),
            )
    }

    private fun setUpViewService(){
        listServiceMenu =createDummyServiceList()
        serviceMenuAdapter= ServiceMenuAdapter(listServiceMenu)
        binding.vComponentHomeService.rvService.adapter= serviceMenuAdapter
        binding.vComponentHomeService.rvService.layoutManager = GridLayoutManager(
            context,
            2,
            RecyclerView.HORIZONTAL,
            false
        )
        serviceMenuAdapter.setOnClickMenu {
            Toast.makeText(context,it.menuTitle, Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateSaving(){
        binding.vComponentHomeSaving.apply {
            btnShowMore.isVisible = listSaving.size>2
            btnShowMore.setOnClickListener {
                savingAdapter.updateQuantitySize(listSaving.size)
                btnShowMore.visibility=View.GONE
                btnShowLess.visibility=View.VISIBLE
            }
            btnShowLess.setOnClickListener{
                savingAdapter.updateQuantitySize(2)
                btnShowMore.visibility=View.VISIBLE
                btnShowLess.visibility=View.GONE
            }
        }
    }


//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }


}