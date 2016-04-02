# CustomGaugeView
# Introduction

CustomGaugeView is a small library to create and display Gauge graphs for Android. It is fully customizable: you can set the color, size, text, range values and many other properties of the graph.


![Alt text](https://raw.githubusercontent.com/thuat26/CustomGaugeView/master/art/demo.gif "Demo screenshot")

# Thanks to

This project forked from https://github.com/Sulejman/GaugeView

Special thanks to Sulejman and CodeAndMagic (https://github.com/CodeAndMagic/GaugeView)

# Installation

## Gradle

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
	
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.thuat26:CustomGaugeView:1.0'
	}
	
##Manual install

Download GaugeView and import library project inside your project.

#Usage

Step 1. Add this line to the top of your activity layout:

```HTML
  xmlns:gauge="http://schemas.android.com/apk/res-auto";
```

Step 2. And add this element too:

```HTML
  <com.ntt.customgaugeview.library.GaugeView
      android:id="@+id/gauge_view"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:layout_centerInParent="true"
      android:layout_margin="16dp"
      gauge:divisions="8"
      gauge:subdivisions="1"
      gauge:rangeValues="@array/speedTestRangeValues"
      gauge:scaleEndValue="5000"
      gauge:showInnerRim="false"
      gauge:showNeedle="true"
      gauge:showOuterBorder="false"
      gauge:showOuterRim="true"
      gauge:showOuterShadow="false"
      gauge:showRangeText="true"
      gauge:showRanges="true"
      gauge:showScale="true"
      gauge:textUnit="KB/s"
      gauge:textUnitSize="0.06"
      gauge:textValueSize="0.15" />
```

Step 3. Create speedTestRangeValues array in attrs file:
  ```HTML
  <string-array name="speedTestRangeValues">
      <item>0</item>
      <item>100</item>
      <item>200</item>
      <item>300</item>
      <item>500</item>
      <item>1000</item>
      <item>2000</item>
      <item>3000</item>
      <item>5000</item>
  </string-array>
  ```
  
Step 4. Add some lines into your Activity:

  ```HTML
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GaugeView gaugeView = (GaugeView) findViewById(R.id.gauge_view);
        final Button btnStart = (Button) findViewById(R.id.btn_start);
        gaugeView.setShowRangeValues(true);
        gaugeView.setTargetValue(0);
        final Random random = new Random();
        final CountDownTimer timer = new CountDownTimer(10000, 2) {
            @Override
            public void onTick(long millisUntilFinished) {
                gaugeView.setTargetValue(random.nextInt(5000));
            }

            @Override
            public void onFinish() {
                gaugeView.setTargetValue(0);
            }
        };
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
            }
        });
    }
  ```
