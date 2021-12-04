package javafxprojects.cryptoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafxprojects.cryptoapp.coin.Coin;
import javafxprojects.cryptoapp.coin.HttpClientCoinGecko;

public class MainController {
    @FXML
    private Label labelBtc,labelEth, labelDoge;
    // Would not be able to access in constructor, labels dont exist when constructor is called
    public void initialize(){
        System.out.println("Hello World!");
        Coin btcCoin = new Coin("bitcoin");
        Coin dogeCoin = new Coin("dogecoin");
        Coin ethereum = new Coin("ethereum");

        try{
            HttpClientCoinGecko.updatePrice(btcCoin);
            HttpClientCoinGecko.updatePrice(dogeCoin);
            HttpClientCoinGecko.updatePrice(ethereum);
        } catch( Exception e){
            e.printStackTrace();
        }
        // better way to do this would be to bind to a label
        // then set on a timer
        labelBtc.setText("$ "+btcCoin.getCurPrice().toString());
        labelDoge.setText("$ "+dogeCoin.getCurPrice().toString());
        labelEth.setText("$ "+ethereum.getCurPrice().toString());
    }
}