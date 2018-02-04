package br.com.bmnv.portalaluno.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static br.com.bmnv.portalaluno.app.R.id.imageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String loginUsuario, id, curso;
    String url;
    TextView nome_pessoa, curso_pessoa;
    ImageView image_user;

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View nav = navigationView.getHeaderView(0);

        nome_pessoa = (TextView)nav.findViewById(R.id.nome_pessoa);
        curso_pessoa = (TextView)nav.findViewById(R.id.curso_pessoa);
        image_user = (ImageView)nav.findViewById(imageView);


        loginUsuario = getIntent().getExtras().getString("email");
        curso = getIntent().getExtras().getString("curso");



        url = "http://icon-icons.com/icons2/546/PNG/512/1455554989_users-6_icon-icons.com_53279.png";
        Picasso.with(this)
                .load(url)
                .resize(200, 150)
                .centerCrop()
                .transform(new CircleTransform())
                .into(image_user);


        nome_pessoa.setText(loginUsuario);
        curso_pessoa.setText(curso);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_acompanhamento) {

        } else if (id == R.id.nav_anotacao) {

        } else if (id == R.id.nav_biblioteca) {

        } else if (id == R.id.nav_meu_perfil) {

        } else if (id == R.id.nav_meus_livros) {

        } else if (id == R.id.nav_sair) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void sair(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        loginUsuario = null;
        id = null;
        curso = null;
        startActivity(intent);
        finish();
    }
}
