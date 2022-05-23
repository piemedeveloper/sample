package com.example.testingapi.api.compose.data

import com.example.testingapi.api.compose.model.Pie
import com.example.testingapi.api.compose.model.User

object MockData {
    val tweets = listOf(
        Pie(
            id = 1,
            user = User(
                id = 1,
                name = "Kevin Kenei",
                username = "@voke",
                profilePic = "https://external-preview.redd.it/1T-uR-y5Sw9ima02pxp70JXbAHhzwlAe5gmV0V3Jp9U.png?width=640&crop=smart&auto=webp&s=a6133f8dedc7e950f8be0d158809932a2e2a12ca"
            ),
            hasImage = true,
            imageUrl = "https://www.rollingstone.com/wp-content/uploads/2021/08/kanye-west-donda-review.jpg",
            numComments = 10,
            numLikes = 121,
            numRetweets = 67,
            date = "21 Sep",
            text = "The self-soilers, the harmony-hushers.\n" +
                    "Even if you are not ready for the day, it cannot always be night"

        ),
        Pie(
            id = 2,
            user = User(
                id = 1,
                name = "Voke Ken",
                username = "@Ken",
                profilePic = "https://external-preview.redd.it/1T-uR-y5Sw9ima02pxp70JXbAHhzwlAe5gmV0V3Jp9U.png?width=640&crop=smart&auto=webp&s=a6133f8dedc7e950f8be0d158809932a2e2a12ca"
            ),
            hasImage = false,
            imageUrl = "",
            numComments = 10,
            numLikes = 121,
            numRetweets = 67,
            date = "21 Sep",
            text = "The self-soilers, the harmony-hushers.\n" +
                    "Even if you are not ready for the day, it cannot always be night"

        ),
        Pie(
            id = 3,
            user = User(
                id = 1,
                name = "Brian Tsuma",
                username = "@Brayo",
                profilePic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTx1ypsGVKFn0Rd8fJMwbue53FlPzzjBcd47w&usqp=CAU"
            ),
            hasImage = true,
            imageUrl = "https://thumbs.dreamstime.com/b/pizza-12182650.jpg",
            numComments = 10,
            numLikes = 121,
            numRetweets = 67,
            date = "21 Sep",
            text = "The self-soilers, the harmony-hushers.\n" +
                    "Even if you are not ready for the day, it cannot always be night"

        ),
    )
}