package com.example.cryptonite.presentation.main_screen.components.deposit_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.domain.model.user_coin.UserCoin


@Composable
fun WalletCoinItem(
    userCoin: UserCoin
) {


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(
                color = if (isSystemInDarkTheme()) Color.Black else Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(
                RoundedCornerShape(24.dp)
            ),
        elevation = 8.dp,
        color = Color.White
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {

            Image(
                painter = rememberImagePainter(userCoin.image),
                contentDescription = "coin_image",
                modifier = Modifier
                    .weight(
                        weight = 1.0f
                    )
                    .clip(MaterialTheme.shapes.small)
                    .width(35.dp)
                    .height(35.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(2.0f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = userCoin.name,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 22.sp
                )

                Text(
                    text = "0.25395 ${userCoin.id.uppercase()}",
                    color = Color.LightGray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }

            Row(
                modifier = Modifier.weight(2.0f), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "${userCoin.coinPriceChange}$ (${userCoin.coinPriceChangePercentage}%)",
                    color = if (userCoin.coinPriceChangePercentage > 0) Color.Green else Color.Red,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.width(4.dp))

                Icon(
                    imageVector = Icons.Filled.ExpandLess,
                    contentDescription = "arrow_up",
                    tint = if (userCoin.coinPriceChangePercentage > 0) Color.Green else Color.Red
                )


            }

        }


    }

}