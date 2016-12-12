package com.example.bobyk.filterview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bobyk on 12.12.16.
 */

public class ChooseFilterAdapter extends RecyclerView.Adapter<ChooseFilterAdapter.ViewHolder> {
    private List<FilterModel> mCardModels;

    public ChooseFilterAdapter(List<FilterModel> cardModels) {
        this.mCardModels = cardModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.filter_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return mCardModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mImageView = (CircleImageView) v.findViewById(R.id.iv_filter);
        }

        private void bindView(int position) {
            if (mCardModels.get(position) != null) {
                mImageView.setImageBitmap(mCardModels.get(position).getBitmap());
            } else {
                mImageView.setImageBitmap(null);
            }
        }
    }
}
