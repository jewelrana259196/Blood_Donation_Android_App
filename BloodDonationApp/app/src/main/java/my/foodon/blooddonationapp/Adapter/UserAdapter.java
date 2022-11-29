package my.foodon.blooddonationapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import my.foodon.blooddonationapp.Model.User;
import my.foodon.blooddonationapp.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<User> userList;
    Intent intent = new Intent();

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_dislayed_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final User user = userList.get(position);

        holder.type.setText(user.getType());

        if (user.getType().equals("donor")) {
            holder.emailNow.setVisibility(View.VISIBLE);
        }


        holder.userEmail.setText(user.getEmail());
        holder.phoneNumber.setText(user.getPhoneNumber());
        holder.userName.setText(user.getName());
        holder.bloodGroup.setText(user.getBloodGroup());

        holder.emailNow.setOnClickListener(view -> {
            intent.setAction(Intent.ACTION_DIAL);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("tel:".concat(user.getPhoneNumber())));
            context.startActivity(intent);
        });


        Glide.with(context).load(user.getProfilepictureurl()).into(holder.userProfileImage);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView userProfileImage;
        public TextView type, userName, userEmail, phoneNumber, bloodGroup;
        public Button emailNow;
        final User user = new User();

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            userProfileImage = itemView.findViewById(R.id.userProfileImage);
            type = itemView.findViewById(R.id.type);
            userName = itemView.findViewById(R.id.userName);
            userEmail = itemView.findViewById(R.id.userEmail);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            emailNow = itemView.findViewById(R.id.emailNow);

        }
//emailNow.setOnClickListener(view -> {
//            Intent i = new Intent();
//            i.setAction(Intent.ACTION_DIAL);
//            i.setData(Uri.parse("tel:".concat(mobile.getText().toString())));
//            startActivity(i);
//        });
    }

//    private void call(int serial) {
//        Intent i = new Intent();
//        i.setAction(Intent.ACTION_DIAL);
//
//        switch (serial) {
//            case 1:
//                i.setData(Uri.parse("tel:01718803520"));
//                break;
//            case 2:
//                i.setData(Uri.parse("tel:01789029803"));
//                break;
//            case 3:
//                i.setData(Uri.parse("tel:01746713345"));
//                break;
//            case 4:
//                i.setData(Uri.parse("tel:01704651811"));
//                break;
//        }
//
//        startActivity(i);
//    }
//
//    private void startActivity(Intent i) {
//    }
}
