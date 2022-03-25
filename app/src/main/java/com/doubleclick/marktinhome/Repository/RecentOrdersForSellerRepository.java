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
import java.time.Month;
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

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MM yyyy HH:mm:ss aaa");
    //    String date = simpleDateFormat.format(recentOrder.getDate());
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;

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
                                if (recentOrder.getSellerId().equals(myId)) {
                                    recentOrderArrayList.add(recentOrder);
                                }
                            }
                            recentOrder.recentOrder(recentOrderArrayList);
                            getDate(dataSnapshot);
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

        void ListOfYear(ArrayList<ArrayList<ArrayList<Integer>>> years);
    }

    public void getDate(DataSnapshot dataSnapshot) {
        ArrayList<ArrayList<ArrayList<Integer>>> years = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            ArrayList<ArrayList<Integer>> monthaList = new ArrayList<>();
            for (int day = 1; day <= 31; day++) {
                ArrayList<Integer> dayList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    RecentOrder recentOrder = snapshot.getValue(RecentOrder.class);
                   /* Log.e("recentOrder", recentOrder.toString());
                    Log.e("TheDay", simpleDateFormat.format(recentOrder.getDate()).substring(5, 7));
                    Log.e("CounterDay", "" + d);
                    Log.e("currentYear", "" + currentYear);
                    Log.e("test", "" + simpleDateFormat.format(recentOrder.getDate()).substring(5, 7).equals(String.valueOf(d)));*/
                    if (simpleDateFormat.format(recentOrder.getDate()).contains(String.valueOf(currentYear)) && recentOrder.getSellerId().equals(myId) && simpleDateFormat.format(recentOrder.getDate()).substring(5, 7).equals(String.valueOf(day)) && month == Integer.parseInt(simpleDateFormat.format(recentOrder.getDate()).substring(8, 10))) {
                        dayList.add(1);
                        dayList.add(1);
                        dayList.add(1);
                        dayList.add(1);
                        dayList.add(1);
                    }
                }
                monthaList.add(dayList);
            }
            years.add(monthaList);
        }
        recentOrder.ListOfYear(years);
//        getColumnData();
    }


    public static ColumnChartData getColumnData() {
        ColumnChartData columnData;
        int numSubcolumns = 1;
        int numColumns = months.length;
        List<AxisValue> axisValues = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {
            values = new ArrayList<>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) 10, ChartUtils.pickColor()));// SubcolumnValue ( value ,color )
            }
            axisValues.add(new AxisValue(i).setLabel(months[i]));
            columns.add(new Column(values).setHasLabelsOnlyForSelected(true));
        }
        columnData = new ColumnChartData(columns);
        columnData.setAxisXBottom(new Axis(axisValues).setHasLines(true));
        columnData.setAxisYLeft(new Axis().setHasLines(true).setMaxLabelChars(2));

        return columnData;
    }
}
