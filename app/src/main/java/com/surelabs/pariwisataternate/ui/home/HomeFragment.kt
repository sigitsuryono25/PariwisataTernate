package com.surelabs.pariwisataternate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.surelabs.pariwisataternate.R
import com.surelabs.pariwisataternate.ui.galeri.GaleriFragment
import com.surelabs.pariwisataternate.ui.lokasi.LokasiWisata
import com.surelabs.pariwisataternate.ui.portal.PortalFragment
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val imageList = arrayOf(
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-1-Indonesia-Kaya.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-2-Lelungan.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-3-Hipwee.jpeg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-3-Hipwee.jpeg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-5-Tribunnews.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-6-Kompas.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-7-Indonesia-Tourism-Forum.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-8-Situs-Budaya.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-9-Indonesia-Kaya.jpg",
        "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-10-Wisata-Lengkap.jpg"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView.setImageListener { position, imageView ->
            activity?.let { Glide.with(it).load(imageList.get(position)).into(imageView) }
        }
        carouselView.pageCount = imageList.size

        portalWisata.setOnClickListener {
            //set title
            activity?.setTitle("Portal Wisata")
            activity!!.nav_host_fragment.childFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, PortalFragment()).commit()
        }

        lokasi.setOnClickListener {
            activity?.title = "Lokasi Wisata"
            activity!!.nav_host_fragment.childFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, LokasiWisata()).commit()
        }

        galeriWisata.setOnClickListener {
            activity?.title = "Galeri Wisata"
            activity!!.nav_host_fragment.childFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, GaleriFragment()).commit()
        }

        tentangKami.setOnClickListener {

        }
    }
}