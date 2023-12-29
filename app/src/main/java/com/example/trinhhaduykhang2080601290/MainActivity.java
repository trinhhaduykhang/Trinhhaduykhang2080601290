package com.example.trinhhaduykhang2080601290;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trinhhaduykhang2080601290.adapter.SanPhamAdapter;
import com.example.trinhhaduykhang2080601290.dao.SanPhamDAO;
import com.example.trinhhaduykhang2080601290.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SanPhamDAO sanPhamDAO = new SanPhamDAO(this);
        ArrayList<SanPham> listSanPham = sanPhamDAO.getListSanPham();
        sanPhamAdapter = new SanPhamAdapter(this, listSanPham);
        recyclerView.setAdapter(sanPhamAdapter);
    }

    public void refreshRecyclerView() {
        SanPhamDAO sanPhamDAO = new SanPhamDAO(MainActivity.this);
        ArrayList<SanPham> list = sanPhamDAO.getListSanPham();
        SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(MainActivity.this, list);
        recyclerView.setAdapter(sanPhamAdapter);
    }
}
