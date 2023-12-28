package com.example.sqlite_todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ToDoAdapter extends ArrayAdapter<ToDo> {
    private Context context;
    private List<ToDo> tasks;

    public ToDoAdapter(Context context, List<ToDo> tasks) {
        super(context, 0, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
        }

        ToDo currentTask = getItem(position);

        TextView taskTitle = convertView.findViewById(R.id.task_title);
        TextView taskContent = convertView.findViewById(R.id.task_content);
        TextView taskDate = convertView.findViewById(R.id.task_date);

        if (currentTask != null) {
            taskTitle.setText(currentTask.getTitle());
            taskContent.setText(currentTask.getContent());
            taskDate.setText(currentTask.getDate());
        }

        return convertView;
    }

    public ToDo getSelectedItem(int position) {
        return getItem(position);
    }
}
