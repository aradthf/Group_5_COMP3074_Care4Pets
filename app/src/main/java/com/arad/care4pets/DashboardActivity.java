package com.arad.care4pets;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;
    private RecyclerView rvUpcomingReminders;
    private DashboardReminderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        calendarView = findViewById(R.id.calendarView);
        rvUpcomingReminders = findViewById(R.id.rvUpcomingReminders);
        ImageButton btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        setupCalendar();
        setupReminders();
    }

    private void setupCalendar() {
        HashSet<CalendarDay> dates = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        for (Reminder reminder : FakeRepository.reminders) {
            try {
                Date date = sdf.parse(reminder.getDate());
                if (date != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    dates.add(CalendarDay.from(cal));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        calendarView.addDecorator(new EventDecorator(Color.parseColor("#A370F7"), dates));
    }

    private void setupReminders() {
        rvUpcomingReminders.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DashboardReminderAdapter(getUpcomingReminders());
        rvUpcomingReminders.setAdapter(adapter);
    }

    private List<Reminder> getUpcomingReminders() {
        return FakeRepository.reminders;
    }
}
