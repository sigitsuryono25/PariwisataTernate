package com.surelabs.pariwisataternate.ui.galeri

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.surelabs.pariwisataternate.R
import kotlinx.android.synthetic.main.fragment_galeri.*

class GaleriFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_galeri, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterGaleri(imageList.toList())
        galeriWisataRv.layoutManager = GridLayoutManager(activity, 2)
        galeriWisataRv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}