package campus.ajns.com.campussse;

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private Context mCtx;
    private List<Location> locationList;

    public LocationAdapter(Context mCtx, List<Location> locationList) {
        this.mCtx = mCtx;
        this.locationList = locationList;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.location, null);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        Location location = locationList.get(position);
        holder.locname.setText(location.getLocname());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class LocationViewHolder extends RecyclerView.ViewHolder {

        TextView locname;

        public LocationViewHolder(View itemView) {
            super(itemView);

            locname = itemView.findViewById(R.id.loctext);


        }
    }

}
