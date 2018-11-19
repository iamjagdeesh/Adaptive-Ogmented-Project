﻿using System;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;


public class ScriptToTrigger : MonoBehaviour {

	public GameObject userInfoUI;

	void Start() {
		Debug.Log ("Script to Trigger called!");
		DisplayUserInfoUI ();
	}

	public void ShowObject(GameObject gameObjectArg) {
		Debug.Log ("Showing GO: " + gameObjectArg.name);
		gameObjectArg.SetActive (true);
		UpdateSomething (gameObjectArg);
	}

	public void HideObject(GameObject gameObjectArg) {
		Debug.Log ("Hiding GO: " + gameObjectArg.name);
		gameObjectArg.SetActive (false);
	}

	public void DisplayUserInfoUI () {
		//Make a rest call here to fetch the details or send details from login()
		userInfoUI.SetActive (true);
		Text userName = userInfoUI.transform.GetChild (0).GetComponent<Text> ();
		userName.text = StaticGameInfo.userName;
	}

	public void UpdateSomething(GameObject gameObjectArg) {
		switch (gameObjectArg.name) {
		case "Hint Text":
			Text hintText = gameObjectArg.GetComponent<Text> ();
			hintText.text = StaticGameInfo.hint;
			break;
		}
	}

}