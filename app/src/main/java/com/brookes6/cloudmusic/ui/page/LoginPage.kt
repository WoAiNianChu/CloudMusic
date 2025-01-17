package com.brookes6.cloudmusic.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.brookes6.cloudmusic.R
import com.brookes6.cloudmusic.constant.RouteConstant
import com.brookes6.cloudmusic.extensions.paddingEnd
import com.brookes6.cloudmusic.ui.theme.*

/**
 * Author: fuxinbo

 * Date: 2023/1/12

 * Description: 登陆引导页
 */
@Preview(showSystemUi = true)
@Composable
fun LoginPage(navController : NavController? = null) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBackground)
            .padding(7.dp, 0.dp, 20.dp, 0.dp)
    ) {
        val (imgTop, bottomBox) = remember { createRefs() }
        Image(
            painter = painterResource(id = R.mipmap.ic_login_bg),
            contentDescription = stringResource(id = R.string.description),
            modifier = Modifier
                .constrainAs(imgTop) {
                    top.linkTo(parent.top, 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Column(
            modifier = Modifier
                .background(secondaryBackground, RoundedCornerShape(40.dp))
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .constrainAs(bottomBox) {
                    bottom.linkTo(parent.bottom, 30.dp)
                    start.linkTo(parent.start, 11.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(text = stringResource(id = R.string.app_name), fontSize = 10.sp, color = minTitleColor)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Welcome toElexto App",
                modifier = Modifier.width(179.dp),
                fontSize = 28.sp,
                color = titleColor
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "Make life better with music and endless inspiration",
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingEnd(20.dp),
                fontSize = 14.sp,
                color = titleColor
            )
            Button(
                onClick = {
                    navController?.navigate(RouteConstant.PHONE_LOGIN_PAGE)
                },
                modifier = Modifier
                    .padding(0.dp, 32.dp, 0.dp, 24.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(mainButtonColor)
            ) {
                Text(text = "登陆", fontSize = 14.sp, color = titleColor)
            }
        }
    }
}