package org.javacs.kt.formatter

import com.github.shyiko.ktlint.core.KtLint
import com.github.shyiko.ktlint.core.RuleSetProvider
import com.github.shyiko.ktlint.Main
import java.util.ServiceLoader
import org.javacs.kt.LOG
import org.javacs.kt.util.attempt

class KotlinFormatter {
	private val ruleSets = listOf(KLSRuleSetProvider.get())
	
	public fun format(code: String) = KtLint.format(code, ruleSets) { err, corrected ->
		LOG.warning("KtLint error while formatting: ${err.detail}")
	}
}
