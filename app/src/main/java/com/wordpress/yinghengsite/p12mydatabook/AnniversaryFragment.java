package com.wordpress.yinghengsite.p12mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;



public class AnniversaryFragment extends Fragment {

    View view;
    Button btnEdit;
    TextView tvAnniversary;
    private DrawerLayout drawerLayout;
    private ListView drawerList;


    public AnniversaryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.anniversaryfragment, container, false);
        btnEdit = (Button)view.findViewById(R.id.btnEdit);




        tvAnniversary = (TextView)view.findViewById(R.id.tvAnniversary);
        tvAnniversary.setText("");



        drawerLayout = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
        drawerList = (ListView)getActivity().findViewById(R.id.left_drawer);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerList);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LayoutInflater inflater = (LayoutInflater)
                        getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase =
                        (LinearLayout) inflater.inflate(R.layout.dialogactivity, null);
                final EditText etSomething = (EditText) passPhrase
                        .findViewById(R.id.etBio);

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Edit Anniversary")
                        .setView(passPhrase)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                tvAnniversary.setText(etSomething.getText().toString().trim());
                            }
                        }).setNegativeButton("Cancel",null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


        return view;
    }

}
