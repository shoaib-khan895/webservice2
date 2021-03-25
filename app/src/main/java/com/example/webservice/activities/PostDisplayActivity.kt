package com.example.webservice.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webservice.R
import com.example.webservice.adapters.PostDetailsAdapter
import com.example.webservice.models.ResponseModel
import com.example.webservice.models.DataModel
import com.example.webservice.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_post_display.*
import retrofit2.Response

class PostDisplayActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<DataModel>()
    private lateinit var customAdapter: PostDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_display)

        createProgressDialog()

        setupRecyclerView()

        getPostsData()
    }


    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait while we are fetching post...")
        progressDialog.setCancelable(false)
    }


    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        post_details_RV.layoutManager = linearLayoutManager

        customAdapter = PostDetailsAdapter(this@PostDisplayActivity, dataList)
        post_details_RV.adapter = customAdapter
    }

    private fun getPostsData() {
        progressDialog.show()

        val call = ApiClient.getClient.getPosts()
        call.enqueue(object : retrofit2.Callback<ResponseModel>{

            override fun onFailure(call: retrofit2.Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@PostDisplayActivity, "There is some error while getting post", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                dataList.addAll(response.body()?.posts?: ArrayList())
                post_details_RV.adapter!!.notifyDataSetChanged()
                progressDialog.dismiss()

            }

        })
    }
}