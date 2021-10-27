package com.anangkur.storybooknativeplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier

class MainActivity : AppCompatActivity() {

    companion object {
        const val QUERY_COMPONENT = "component"

        const val COMPONENT_BUTTON = "button"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text("hello world!")
                    }
                }
            )
        }

        handleIntent(intent.data?.getQueryParameter(QUERY_COMPONENT))
    }

    private fun handleIntent(component: String?) {
        when (component) {
            COMPONENT_BUTTON -> startActivity(Intent(this, ButtonActivity::class.java))
        }
    }
}