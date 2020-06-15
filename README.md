# Glottie

Shows Lottie animation while loading image using Glide. 
It is a simple FrameLayout with ImageView and LottieAnimationView inside it.

It supports all Lottie and ImageView XML attributes.

## Download

Gradle:
```groovy
implementation "com.clzola:glottie:1.4.0"
```

Maven:
```xml
<dependency>
  <groupId>com.clzola</groupId>
  <artifactId>glottie</artifactId>
  <version>1.4.0</version>
  <type>pom</type>
</dependency>
```

## Usage

In XML file:
```xml
<com.clzola.glottie.GlottieView
        android:id="@+id/image"
        android:layout_width="300dp"
        android:layout_height="450dp"
        app:lottie_fileName="loading.json"
        app:lottie_loop="true"
        android:scaleType="centerCrop"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

In your activity:
```kotlin
val imageView = findViewById<GlottieView>(R.id.image)

GlideApp.with(this)
    .load("...")
    .error(R.drawable.error)
    .into(GlottieViewTarget(imageView))
```