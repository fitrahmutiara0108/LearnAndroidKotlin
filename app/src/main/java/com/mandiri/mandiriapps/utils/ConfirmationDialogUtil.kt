package com.mandiri.mandiriapps.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.DialogLayoutBinding
import com.mandiri.mandiriapps.presentation.HomeMainActivity

class ConfirmationDialogUtil(private val context: Context) {

    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
        isOnHistoryTransaction: Boolean
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        // inflate dialog_confirmation.xml layout using ViewBinding
        val dialogView= LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val dialogBinding = DialogLayoutBinding.bind(dialogView)
        dialogBinding.tvTitleDialog.text = title

        //set judul dan pesan
//        if(isOnHistoryTransaction){
//            dialogBinding.tvTitleDialog.text = "History Transaction"
//            dialogBinding.tvMessageDetail.text = "Anda yakin ingin menuju halaman Detail Transaksi?"
//        }
//        else{
//            dialogBinding.tvTitleDialog.text = "Log Out"
//            dialogBinding.tvMessageDetail.text = "Anda yakin ingin keluar dari halaman ini?"
//        }


        if(icon != null){
            dialogBinding.ivIconDialog.visibility=View.VISIBLE
            dialogBinding.ivIconDialog.setImageResource(icon)
        }
        else{
            dialogBinding.ivIconDialog.visibility=View.GONE
        }

        alertDialog.setView(dialogView)

        //menambahkan fungsi onClickListener untuk tombol "Ya"
        dialogBinding.btnPositive.setOnClickListener{
            onConfirm() //panggil aksi onConfirm
            alertDialog.dismiss()
        }

        //menambahkan fungsi onClickListener untuk tombol "Tidak"
        dialogBinding.btnNegative.setOnClickListener{
            onCancel() //panggil aksi onConfirm
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}