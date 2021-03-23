package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * 月份选择器
 * <p>
 * Picker for Months
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelMonthPicker extends WheelPicker implements IWheelMonthPicker {
    private String mSelectedMonth;
    private int mSelectedMonthPosition;

    public WheelMonthPicker(Context context) {
        this(context, null);
    }

    public WheelMonthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        List<String> monthNames = Arrays.asList(DateFormatSymbols.getInstance(Locale.US).getMonths());
        super.setData(monthNames);

        mSelectedMonthPosition = Calendar.getInstance().get(Calendar.MONTH);
        mSelectedMonth = monthNames.get(mSelectedMonthPosition);
        updateSelectedYear();
    }

    private void updateSelectedYear() {
        setSelectedItemPosition(mSelectedMonthPosition);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    @Override
    public String getSelectedMonth() {
        return mSelectedMonth;
    }

    @Override
    public void setSelectedMonth(int month) {
        mSelectedMonthPosition = month - 1;
        updateSelectedYear();
    }

    @Override
    public String getCurrentMonth() {
        return String.valueOf(getData().get(getCurrentItemPosition()));
    }
}