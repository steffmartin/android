package move.pdsi.facom.ufu.br.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import move.pdsi.facom.ufu.br.move.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class relatoriosFragment extends Fragment {


    public relatoriosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relatorios, container, false);
    }

}
