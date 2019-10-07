package edu.cnm.deepdive.blackjack.controller;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.blackjack.R;
import edu.cnm.deepdive.blackjack.model.entity.Card;
import edu.cnm.deepdive.blackjack.model.entity.Card.Rank;
import edu.cnm.deepdive.blackjack.model.entity.Card.Suit;
import edu.cnm.deepdive.blackjack.model.entity.Shoe;
import edu.cnm.deepdive.blackjack.service.BlackjackDatabase;
import edu.cnm.deepdive.blackjack.viewmodel.MainViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ListView cards = findViewById(R.id.cards);
    ArrayAdapter<Card> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
    cards.setAdapter(adapter);
    MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    viewModel.getRound().observe(this, (round) -> {
      adapter.clear();
      adapter.addAll(round.getHands().get(0).getCards());
    });
    Button addDeck = findViewById(R.id.start_round);
    addDeck.setOnClickListener(view -> viewModel.startRound());
  }

}
