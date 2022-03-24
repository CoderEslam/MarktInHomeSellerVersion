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

    String date = "";
    int currentYear = 0;
    int currentMonth = 0;
    String month = "";
    ArrayList<Integer> Columns = new ArrayList<>();
    int C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12;

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
    }

    public void getDate(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            RecentOrder recentOrder = snapshot.getValue(RecentOrder.class);
            if (recentOrder.getSellerId().equals(myId)) {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MM yyyy HH:mm:ss aaa");
                date = simpleDateFormat.format(recentOrder.getDate());
                currentYear = Calendar.getInstance().get(Calendar.YEAR);
                currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
                month = String.valueOf(Integer.parseInt(date.substring(8, 10)));
                date.contains(String.valueOf(currentYear));
                month.equals(String.valueOf(currentMonth));
            }
        }
        getColumnData();
    }


    private ColumnChartData getColumnData() {
        ColumnChartData columnData;
        for (int i = 0; i < 12; i++) {
            Log.e("values", "values.toString()");
            /*if (date.contains(String.valueOf(currentYear))) {
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 1) {
                    C1 += 1;
                    Columns.add(1, C1);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 2) {
                    C2 += 1;
                    Columns.add(2, C2);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 3) {
                    C3 += 1;
                    Columns.add(3, C3);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 4) {
                    C4 += 1;
                    Columns.add(4, C4);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 5) {
                    C5 += 1;
                    Columns.add(5, C5);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 6) {
                    C6 += 1;
                    Columns.add(6, C6);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 7) {
                    C7 += 1;
                    Columns.add(7, C7);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 8) {
                    C8 += 1;
                    Columns.add(8, C8);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 9) {
                    C9 += 1;
                    Columns.add(9, C9);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 10) {
                    C10 += 1;
                    Columns.add(10, C10);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 11) {
                    C11 += 1;
                    Columns.add(11, C11);
                }
                if (Integer.parseInt(String.valueOf(Integer.parseInt(date.substring(8, 10)))) == 12) {
                    C12 += 1;
                    Columns.add(12, C12);
                }
            }*/
        }
        int numSubcolumns = 1;
        int numColumns = months.length;
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {
            values = new ArrayList<SubcolumnValue>();
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
