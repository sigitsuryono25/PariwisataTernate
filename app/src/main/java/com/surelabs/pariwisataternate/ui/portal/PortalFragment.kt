package com.surelabs.pariwisataternate.ui.portal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.surelabs.pariwisataternate.R
import kotlinx.android.synthetic.main.fragment_portal.*

class PortalFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        portalWisataWeb.settings.javaScriptEnabled = true
        portalWisataWeb.settings.javaScriptCanOpenWindowsAutomatically = true
        portalWisataWeb.settings.loadsImagesAutomatically = true

        portalWisataWeb.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }


            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, url)
            }
        }


        portalWisataWeb.loadUrl("https://www.tokopedia.com/blog/travel-tempat-wisata-di-ternate/")

    }
}