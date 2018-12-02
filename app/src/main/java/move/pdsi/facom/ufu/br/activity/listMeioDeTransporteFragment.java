package move.pdsi.facom.ufu.br.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import move.pdsi.facom.ufu.br.daos.meiosdetransporte.MeiosDeTransporteDAO;
import move.pdsi.facom.ufu.br.model.meiosdetransporte.MeioDeTransporte;
import move.pdsi.facom.ufu.br.move.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class listMeioDeTransporteFragment extends Fragment {

    MeiosDeTransporteDAO dao;
    RecyclerView recyclerView;

    public listMeioDeTransporteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_meios_de_transporte, container, false);
        dao = new MeiosDeTransporteDAO(getActivity().getApplicationContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.listaDeMeiosTransporte);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MeioTransporteAdapter(dao.readAllSpecific(), new MeioTransporteAdapter.OnMeioDeTransporteClickListener() {
            @Override
            public void onItemClick(MeioDeTransporte item) {
                Intent intent = new Intent(getActivity().getApplicationContext(), readMeioDeTransporteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        }, getActivity().getApplicationContext()));

        FloatingActionButton btnAddMeioDeTranporte = (FloatingActionButton) view.findViewById(R.id.addMeiodeTransporte);
        btnAddMeioDeTranporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), addMeioDeTranporteParticularActivity.class);
                startActivityForResult(intent, getResources().getInteger(R.integer.INTENT_ADD_TRANSPORTE));
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == getResources().getInteger(R.integer.INTENT_ADD_TRANSPORTE) && resultCode == getResources().getInteger(R.integer.SUCESS)) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();
        }
    }
}
