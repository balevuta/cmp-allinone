package org.ethan.allinone.ui.composeui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.ethan.allinone.data.model.Product
import org.ethan.allinone.theme.AppColors

@Composable
fun ProductCard(list: List<Product>, onProductClick: (Product) -> Unit) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxSize()
    )
    {
        header {
            ImageSliderHomeBanner(bannerImages())
        }
        item(span = { GridItemSpan(this.maxLineSpan) }) {
            Text(
                text = "Our latest offers",
                fontSize = 20.sp,
                color = AppColors.lightBellBlue
            )
        }
        items(list.size) { index ->
            val data = list[index]
            ProductItem(data, onProductClick)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSliderHomeBanner(list: List<Any>) {
    Column {
        Text(
            text = "Save 35% on iPhone 15 on Canada’s fastest 5G+ network",
            fontSize = 20.sp,
            color = AppColors.lightBellBlue
        )

        Spacer(modifier = Modifier.height(10.dp))

        val pagerState = rememberPagerState(
            initialPage = 0, initialPageOffsetFraction = 0f
        ) { list.size }
        HorizontalPager(modifier = Modifier,
            state = pagerState,
            pageSpacing = 0.dp,
            userScrollEnabled = true,
            reverseLayout = false,
            contentPadding = PaddingValues(0.dp),
            pageSize = PageSize.Fill,
            key = null,
//        pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
//            pagerState, Orientation.Horizontal
//        ),
            pageContent = {
                Card(
                    shape = CardDefaults.elevatedShape,
                    modifier = Modifier.fillMaxWidth().padding(9.dp)
                        .height(160.dp)
                        .background(Color.Transparent),
                ) {
                    KamelImage(
                        resource = asyncPainterResource(data = list[it % list.size]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            })

//    crash on Android, not consistently on iOS
//    LaunchedEffect(key1 = Unit) {
//        var initPage = Int.MAX_VALUE / 2
//        while (initPage % list.size != 0) {
//            initPage++
//        }
//        pagerState.scrollToPage(initPage)
//    }

//    LaunchedEffect(key1 = pagerState.currentPage) {
//        launch {
//            while (true) {
//                delay(3000)
//                withContext(NonCancellable) {
//                    if (pagerState.currentPage + 1 in 0..Int.MAX_VALUE) {
//                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
//                    } else {
//                        var initPage = Int.MAX_VALUE / 2
//                        pagerState.scrollToPage(initPage)
//
//                    }
//                }
//            }
//        }
//    }
    }
}

@Composable
fun ProductItem(product: Product, onProductClick: (Product) -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight().clickable { onProductClick(product) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = Modifier
                //.height(350.dp)
                .background(AppColors.lightBellBlue).padding(10.dp)
        ) {
            KamelImage(
                resource = asyncPainterResource(data = product.thumbnail),
                contentDescription = null,
                modifier = Modifier
                    //.height(150.dp)
                    .fillMaxWidth().clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                Text(
                    modifier = Modifier.padding(2.dp),
                    fontSize = 14.sp,
                    text = product.title,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = product.description,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "$${product.price}",
                    fontSize = 14.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "${product.discountPercentage}% discount",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(red = 0.1f, green = 0.8f, blue = 0.0f)
                )
            }
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}

fun bannerImages(): List<String> {
//    return listOf(
//        "https://img.freepik.com/premium-vector/weekend-sale-banner-template-with-liquid-shapes_85212-187.jpg",
//        "https://img.freepik.com/premium-vector/flat-travel-sale-background_23-2149048750.jpg",
//        "https://img.freepik.com/premium-photo/photocomposition-horizontal-shopping-banner-with-woman-big-smartphone_23-2151201773.jpg",
//        "https://img.freepik.com/premium-vector/digital-marketing-concept-shopping-online-mobile-application_68971-366.jpg"
//    )
    return listOf(
        "https://images.contentstack.io/v3/assets/blt1f8d2d42a5105643/blt315b89738e5852c5/668c41b20325450286884b8a/Apple-iPhone-14-iPhone-14-Plus-hero-220907.jpg.og.jpg",
        "https://img.freepik.com/premium-vector/flat-travel-sale-background_23-2149048750.jpg",
        "https://img.freepik.com/premium-photo/photocomposition-horizontal-shopping-banner-with-woman-big-smartphone_23-2151201773.jpg",
        "https://img.freepik.com/premium-vector/digital-marketing-concept-shopping-online-mobile-application_68971-366.jpg"
    )
}