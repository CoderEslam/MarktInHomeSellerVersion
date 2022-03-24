package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.RECENTORDER;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.marktinhome.Model.RecentOrder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;

/**
 * Created By Eslam Ghazy on 3/23/2022
 */
public class RecentOrdersForSellerRepository extends BaseRepository {

    public final static String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",};

    public final static String[] days = new String[]{"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun",};

    private LineChartData lineData;

    private ColumnChartData columnData;

    private ArrayList<RecentOrder> recentOrderArrayList = new ArrayList<>();
    private recentOrder recentOrder;

    public RecentOrdersForSellerRepository(recentOrder recentOrder) {
        this.recentOrder = recentOrder;
    }

    public void getRecentOrders() {
        reference.child(RECENTORDER).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                RecentOrder recentOrder = snapshot.getValue(RecentOrder.class);
                                if (Objects.requireNonNull(recentOrder).getBuyerId().equals(myId)) {
                                    recentOrderArrayList.add(recentOrder);
                                    getDate(recentOrder);
                                }
                            }
                            recentOrder.recentOrder(recentOrderArrayList);
                        }
                    } else {
                        ShowToast("No internet Connection");
                    }

                } catch (Exception e) {
                    Log.e("RecentOrderException", e.getMessage());
                }

            }
        });
    }

    public interface recentOrder {
        void recentOrder(ArrayList<RecentOrder> recentOrderArrayList);
    }

    public static void getDate(RecentOrder recentOrder) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MM yyyy HH:mm:ss aaa");
        String d = simpleDateFormat.format(recentOrder.getDate());
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String month = String.valueOf(Integer.parseInt(d.substring(8, 10)));
        System.out.println(d.contains(String.valueOf(currentYear)));
        System.out.println(month.equals(String.valueOf(currentMonth)));
    }


    private void generateColumnData() {

        int numSubcolumns = 1;
        int numColumns = months.length;

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));// SubcolumnValue ( value ,color )
            }

            axisValues.add(new AxisValue(i).setLabel(months[i]));

            columns.add(new Column(values).setHasLabelsOnlyForSelected(true));
        }

        columnData = new ColumnChartData(columns);
        columnData.setAxisXBottom(new Axis(axisValues).setHasLines(true));
        columnData.setAxisYLeft(new Axis().setHasLines(true).setMaxLabelChars(2));

    }
}
