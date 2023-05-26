package com.example.jkv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jkv.modal.BathroomAccessoriesModal;
import com.example.jkv.modal.GlassFittingsModal;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccessoriesFragment extends Fragment {


    ArrayList<BathroomAccessoriesModal> bathroomAccessoriesModalArrayList;

    ArrayList<GlassFittingsModal> glassFittingsModalArrayList;

    @BindView(R.id.bathroom_accessories_recycleview)
    RecyclerView bathroom_accessories_recycleview;

    @BindView(R.id.glass_accessories_recycleview)
    RecyclerView glass_accessories_recycleview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_accessories, container, false);

        ButterKnife.bind(this, view);


        BathroomAccessoriesModal JPF_108 = new BathroomAccessoriesModal(R.drawable.accessories, "JPF-108");
        BathroomAccessoriesModal JPF_109 = new BathroomAccessoriesModal(R.drawable.accessories, "JPF-109");
        BathroomAccessoriesModal JPF_107 = new BathroomAccessoriesModal(R.drawable.accessories, "JPF-107");

        bathroomAccessoriesModalArrayList = new ArrayList<>();

        bathroomAccessoriesModalArrayList.add(JPF_108);
        bathroomAccessoriesModalArrayList.add(JPF_109);
        bathroomAccessoriesModalArrayList.add(JPF_107);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        bathroom_accessories_recycleview.setLayoutManager(layoutManager);

        Myadapter myadapter = new Myadapter(getActivity(), bathroomAccessoriesModalArrayList);
        bathroom_accessories_recycleview.setAdapter(myadapter);

        //////////////////////

        GlassFittingsModal JPF_101 = new GlassFittingsModal(R.drawable.accessories,"JPF-101");
        GlassFittingsModal JPF_102 = new GlassFittingsModal(R.drawable.accessories,"JPF-102");
        GlassFittingsModal JPF_103 = new GlassFittingsModal(R.drawable.accessories,"JPF-103");

        glassFittingsModalArrayList = new ArrayList<>();

        glassFittingsModalArrayList.add(JPF_101);
        glassFittingsModalArrayList.add(JPF_102);
        glassFittingsModalArrayList.add(JPF_103);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        glass_accessories_recycleview.setLayoutManager(layoutManager1);

        My2Adapter my2Adapter = new My2Adapter(getActivity(), glassFittingsModalArrayList);
        glass_accessories_recycleview.setAdapter(my2Adapter);

        return view;
    }

    class Myadapter extends RecyclerView.Adapter<AccessoriesFragment.Myadapter.HoldView> {

        public Myadapter(FragmentActivity activity, ArrayList<BathroomAccessoriesModal> bathroomAccessoriesModalArrayList) {
        }



        @NonNull
        @Override
        public HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.bathroom_accessories_layout, parent, false);
            HoldView holdView = new HoldView(view);
            return holdView;
        }

        @Override
        public void onBindViewHolder(@NonNull HoldView holder, int position) {
            BathroomAccessoriesModal bathroomAccessoriesModal = bathroomAccessoriesModalArrayList.get(position);

            holder.accessories_image.setImageResource(bathroomAccessoriesModal.getImage());
            holder.accessories_name.setText(bathroomAccessoriesModal.getAccess_name());

        }

        @Override
        public int getItemCount() {
            return bathroomAccessoriesModalArrayList.size();
        }

        class HoldView extends RecyclerView.ViewHolder {

            @BindView(R.id.accessories_image)
            ImageView accessories_image;
            @BindView(R.id.accessories_name)
            TextView accessories_name;
            @BindView(R.id.button)
            Button button;

            public HoldView(@NonNull View itemView) {
                super(itemView);

                ButterKnife.bind(this, itemView);
            }
        }
    }

    class My2Adapter extends RecyclerView.Adapter<AccessoriesFragment.My2Adapter.HoldView> {
        public My2Adapter(FragmentActivity activity, ArrayList<GlassFittingsModal> glassFittingsModalArrayList) {

        }
        @NonNull
        @Override
        public HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



            View view  = getLayoutInflater().inflate(R.layout.glass_fitting_layout,parent,false);
            HoldView holdView = new HoldView(view);
            return holdView;
        }

        @Override
        public void onBindViewHolder(@NonNull HoldView holder, int position) {
            GlassFittingsModal glassFittingsModal = glassFittingsModalArrayList.get(position);

            holder.accessories_image.setImageResource(glassFittingsModal.getImage());
            holder.accessories_name.setText(glassFittingsModal.getAccess_name());
        }

        @Override
        public int getItemCount() {
            return glassFittingsModalArrayList.size();
        }

        class HoldView extends RecyclerView.ViewHolder {
            @BindView(R.id.accessories_image)
            ImageView accessories_image;
            @BindView(R.id.accessories_name)
            TextView accessories_name;
            @BindView(R.id.button)
            Button button;

            public HoldView(@NonNull View itemView) {
                super(itemView);

                ButterKnife.bind(this,itemView);
            }
        }

    }
}
