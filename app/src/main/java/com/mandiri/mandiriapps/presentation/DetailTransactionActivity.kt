package com.mandiri.mandiriapps.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.databinding.ActivityDetailTransactionBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.StatusTransaction
import com.mandiri.mandiriapps.model.StatusTransfer

class DetailTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTransactionBinding
    private var data: HistoryTransactionModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.componentToolbar.tvTitle.text = "Detail History"

        binding.componentToolbar.ivBack.setOnClickListener {
            this.onBackPressed()
        }

        data = intent?.getParcelableExtra(DATA_TRANSACTION)
        checkTransactionType()
        setupViewDetail()

    }

    private fun checkTransactionStatus(): String {
        val dataTransaction = data?.statusTransaction
        var resultTransaction = ""
        when (dataTransaction) {
            StatusTransaction.Berhasil.value -> resultTransaction = "Pembayaran Berhasil"
            StatusTransaction.Gagal.value -> resultTransaction = "Pembayaran Gagal"
            StatusTransaction.Pending.value -> resultTransaction = "Pembayaran Tertunda"
        }
        return resultTransaction
    }

    private fun checkTransactionType(): String {
        val dataTransaction = data?.titleTransaction
        var resultTransaction = ""
        when (dataTransaction){
            StatusTransfer.Credit.value -> resultTransaction = "Bayar"
            StatusTransfer.Debit.value -> resultTransaction = "Top-Up"
        }
        return resultTransaction
    }

    private fun setupViewDetail() {
        val textDetail = "transaksi saya ${checkTransactionStatus()}"
        binding.vDetailTransaction.tvStatusPembayaran.text = textDetail
    }

    companion object {
        const val DATA_TRANSACTION = "dataTransaction"

        fun navigateToDetailTransaction(activity: Activity, data: HistoryTransactionModel) =
            Intent().apply {
                val intent = Intent(activity, DetailTransactionActivity::class.java)
                intent.putExtra(DATA_TRANSACTION, data)
                activity.startActivity(intent)
            }
    }
}