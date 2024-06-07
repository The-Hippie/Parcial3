package com.example.disneyplus.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.disneyplus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment
implements View.OnClickListener
{

    private FirebaseAuth mAuth;

    private Button btn_cerrar_sesion;
    private EditText edtUsuario;
    private EditText edtPassword;
    private Button btn_ingresar;
    private Button btn_registrar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user==null) {

            view = inflater.inflate(R.layout.fragment_login, container, false);

            edtUsuario = view.findViewById(R.id.edtUsuario);
            edtPassword = view.findViewById(R.id.edtPassword);
            btn_ingresar = view.findViewById(R.id.btn_ingresar);
            btn_registrar = view.findViewById(R.id.btn_registrar);
            btn_registrar.setOnClickListener(this);
            mAuth = FirebaseAuth.getInstance();

            btn_ingresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = edtUsuario.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();

                    if(email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(getActivity(), "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                    } else {
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Navigation.findNavController(view).navigate(R.id.action_nav_login_to_displeyFragment);
                                        } else {
                                            Log.d("Tag", "Error al logear", task.getException());
                                            Toast.makeText(getActivity(), "Error al logear", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            });
        }
        else {
            view = inflater.inflate(R.layout.fragment_login_conectado, container, false);
            btn_cerrar_sesion=view.findViewById(R.id.btn_cerrar_sesion);
            btn_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),
                            "Cerrando sesión",
                            Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    Navigation.findNavController(view).navigate(R.id.action_nav_login_to_nav_home);

                }
            });

        }

       return view;
    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_nav_login_to_loginCreateFragment);



    }
}