package com.example.todomvvm.addedittask;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.todomvvm.R;
import com.example.todomvvm.database.Repository;
import com.example.todomvvm.database.TaskEntry;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddEditTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEditTaskFragment extends Fragment {

    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    // Constants for priority
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_LOW = 3;
    // Constant for default task id to be used when not in update mode
    private static final int DEFAULT_TASK_ID = -1;
    // Constant for logging
    private static final String TAG = AddEditTaskActivity.class.getSimpleName();
    // Fields for views
    EditText mEditTitle;
    EditText mEditText;
    EditText mEditDate;
    RadioGroup mRadioGroup;
    Button mButton;
    Repository repository;

    private int mTaskId = DEFAULT_TASK_ID;


    AddEditTaskViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static AddEditTaskFragment newInstance(){
        AddEditTaskFragment fragment = new AddEditTaskFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_add_edit_task, container, false);
        mEditText = view.findViewById(R.id.editTextTaskDescription);
        mEditDate = view.findViewById(R.id.editTextTaskDate);
        mButton = view.findViewById(R.id.saveButton);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        repository = Repository.getInstance(getActivity().getApplicationContext());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = mEditTitle.getText().toString();
                String description = mEditText.getText().toString();
                String taskDate = mEditDate.getText().toString();
                int priority = 1;
                Date date = new Date();
                TaskEntry todo = new TaskEntry(title, description, priority, date, taskDate);
                todo.setDescription(description);
                todo.setPriority(1);
                todo.setTaskDate(taskDate);
//                repository(todo);
//                Log.d("ADDTODOFRAGMENT", ""+repository.getAllTodos().size());

            }
        });

    }
}