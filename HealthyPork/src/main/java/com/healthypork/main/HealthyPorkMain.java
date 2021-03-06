package com.healthypork.main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.espertech.esper.client.EPSubscriberException;
import com.espertech.esper.client.deploy.DeploymentException;
import com.espertech.esper.client.deploy.ParseException;
import com.healthypork.subscribers.SubscriberObservations;
import com.healthypork.subscribers.SubscriberTemperature;
import com.healthypork.subscribers.SubscriberWeatherHumidity;
import com.healthypork.subscribers.SubscriberWeatherTemp;
import com.healthypork.subscribers.SubscriberWeatherTempFeels;
import com.healthypork.subscribers.SubscriberWeatherTempMax;
import com.healthypork.subscribers.SubscriberWeatherTempMin;
import com.healthypork.subscribers.SubscriberAirQuality;
import com.healthypork.subscribers.SubscriberHumidity;
import com.healthypork.subscribers.SubscriberLuminosity;
import com.healthypork.subscribers.SubscriberNoise;
import com.healthypork.utils.Constants;
import com.healthypork.utils.PatternDetector;

public class HealthyPorkMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, ParseException, DeploymentException,
	InterruptedException, ClassNotFoundException, EPSubscriberException, MqttException {
		HealthyPorkMain test = new HealthyPorkMain();
		
		PatternDetector pd = new PatternDetector(System.getProperty("user.dir")+"/resources/Statements.epl");
		pd.start();
		try {
			SubscriberAirQuality subs_air_quality = new SubscriberAirQuality(new URI(Constants.MQTT_URL));
			SubscriberHumidity subs_humidity = new SubscriberHumidity(new URI(Constants.MQTT_URL));
			SubscriberLuminosity subs_luminosity = new SubscriberLuminosity(new URI(Constants.MQTT_URL));
			SubscriberNoise subs_noise = new SubscriberNoise(new URI(Constants.MQTT_URL));
			SubscriberTemperature subs_temperature = new SubscriberTemperature(new URI(Constants.MQTT_URL));
			SubscriberWeatherHumidity subs_weather_humidity = new SubscriberWeatherHumidity(new URI(Constants.MQTT_URL));
			SubscriberWeatherTemp subs_weather_temp = new SubscriberWeatherTemp(new URI(Constants.MQTT_URL));
			SubscriberWeatherTempFeels subs_weather_temp_feels = new SubscriberWeatherTempFeels(new URI(Constants.MQTT_URL));
			SubscriberWeatherTempMax subs_weather_temp_max = new SubscriberWeatherTempMax(new URI(Constants.MQTT_URL));
			SubscriberWeatherTempMin subs_weather_temp_min = new SubscriberWeatherTempMin(new URI(Constants.MQTT_URL));
			SubscriberObservations subs_observation = new SubscriberObservations(new URI(Constants.MQTT_URL));
		} catch (MqttException | URISyntaxException e) {e.printStackTrace();}
		synchronized (test) {
			test.wait();
		}
	}
}