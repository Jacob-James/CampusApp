package campus.ajns.com.campussse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.List;
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context mCtx;
    private List<Events> EventList;

    public EventAdapter(Context mCtx, List<Events> EventList) {
        this.mCtx = mCtx;
        this.EventList = EventList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.events, null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventAdapter.EventViewHolder holder, int position) {
        Events events = EventList.get(position);


        holder.evname.setText(events.getEvname());
        holder.evloc.setText(events.getEvloc());
        holder.evtime.setText(events.getEvtime());
      //  holder.evdescri.setText(events.getEvdescri());
    }

    @Override
    public int getItemCount() {
        return EventList.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        TextView evname, evloc,evtime,evdescri;

        public EventViewHolder(View itemView) {
            super(itemView);
            evloc = itemView.findViewById(R.id.evloc);
            evname = itemView.findViewById(R.id.evname);
            evtime=itemView.findViewById(R.id.evtime);

        }



        }





}
