package com.example.category

import android.icu.util.ULocale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.category.data.DataSource
import com.example.category.data.Topic
import com.example.category.ui.theme.CategoryTheme
import java.util.Locale.Category

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {

  GridCategoru(
      topics = DataSource.topics,
      modifier = modifier
  )
}


@Composable
fun GridCategoru(topics:List<Topic>  ,modifier: Modifier = Modifier){



    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement =  Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier


    ){
      items(topics){topic ->
          CategoryCard(
              topic = topic,
          )
      }
    }



}

@Composable
fun CategoryCard(topic: Topic , modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Row {

            Image(
                painter = painterResource(id = topic.imgg),
                contentDescription = stringResource(id = topic.catname),
                modifier = Modifier
                    //.fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.Crop


            )

            Column (modifier = Modifier.
            padding( start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 0.dp)){

                Text(
                    text = LocalContext.current.getString(topic.catname),
                    style = MaterialTheme.typography.bodyMedium

                    
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription ="just an image"
                    )
                   Spacer(modifier = Modifier.width(8.dp))

                    Text(text =  (topic.num).toString(),
                        style = MaterialTheme.typography.labelMedium)

                }


            }




        }


    }



}



@Preview(showBackground = true)
@Composable
fun CategoryCardPreview()
{
    CategoryCard(topic = Topic(R.string.architecture, 58, R.drawable.architecture))
}