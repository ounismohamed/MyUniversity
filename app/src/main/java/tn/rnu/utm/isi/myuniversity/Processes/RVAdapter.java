package tn.rnu.utm.isi.myuniversity.Processes;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tn.rnu.utm.isi.myuniversity.R;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CaseViewHolder> {

    @Override
    public CaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CaseViewHolder cvh = new CaseViewHolder(v);
        return cvh;
    }

    List<Case> cases;

    RVAdapter(List<Case> cases){
        this.cases = cases;
    }

  /*  @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }*/

    @Override
    public void onBindViewHolder(CaseViewHolder caseViewHolder, int i) {
        caseViewHolder.pro_title.setText(cases.get(i).getPro_title());
        caseViewHolder.pro_uid.setText(cases.get(i).getPro_uid());
    }

    public static class CaseViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView pro_title;
        TextView pro_uid;
//        ImageView casePhoto;

        CaseViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            pro_title = (TextView)itemView.findViewById(R.id.pro_title);
            pro_uid = (TextView)itemView.findViewById(R.id.pro_uid);
//            casePhoto = (ImageView)itemView.findViewById(R.id.case_photo);
        }
    }

    @Override
    public int getItemCount() {
        return cases.size();
    }
}