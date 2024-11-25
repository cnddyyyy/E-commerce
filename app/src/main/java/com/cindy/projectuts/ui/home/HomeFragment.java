package com.cindy.projectuts.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cindy.projectuts.R;
import com.cindy.projectuts.item.ProductAdapter;
import com.cindy.projectuts.databinding.FragmentHomeBinding;
import com.cindy.projectuts.item.Product;
import com.cindy.projectuts.item.ProductAdapter;
import com.cindy.projectuts.item.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inisialisasi ViewModel
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        // Inflate layout menggunakan View Binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Observasi teks dari ViewModel
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        recyclerView = binding.recyclerViewProducts;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true); // Optimalkan tinggi elemen


        // Buat daftar produk
        productList = new ArrayList<>();
        productList.add(new Product("Women's Zip Up Vest", "Solid Color Oversized Jacket Tops Loose Fit Summer Tops", 1500.0, R.drawable.vest_wanita));
        productList.add(new Product("Women High Waist", " Casual Wide Leg Long Palazzo Pants Button Down Loose Business Work Office Trousers with Pockets Spring and Autumn New Commuting Temperament Relaxed Dress Suit Pants", 800.0, R.drawable.celana_wanita));
        productList.add(new Product("Satin Skirt", "Green Leisure Satin Skirt", 250.0, R.drawable.rok));
        productList.add(new Product("Loose Jackets Men", "Solid Corduroy Spring Autumn Japanese Style New Vintage Turn-down Collar Daily Fashion All-match Outdoor Ins", 250.0, R.drawable.jaket_pria));
        productList.add(new Product("Cargo Shorts", "Splice Pocket Quick Dry Outdoor Cargo Shorts Men Loose Casual Cityboy Japanese Streetwear Fashion", 250.0, R.drawable.celana_pendek));
        productList.add(new Product("Bella Dress ", "COOTELILI Summer Kids Dress For Girls Dress", 250.0, R.drawable.dress_anak));
        productList.add(new Product("Clothes Set", "Easy-Peasy Toddler Girl Eyelet Cotton Shirt and Shorts Set", 250.0, R.drawable.baju_anak));
        productList.add(new Product("Boys Bear Embroidered Corduroy", "Shirts Long Sleeve Button Up Tops Spring Fall Outwear Shirts Jacket Clothes", 250.0, R.drawable.jaket_anak));

        // Pasang adapter
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
